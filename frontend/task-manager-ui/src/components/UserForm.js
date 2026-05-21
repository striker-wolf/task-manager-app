import React, { useEffect, useState } from "react";

function UserForm({
  onUserCreated,
  editingUser,
  setEditingUser
}) {

  const [name, setName] = useState("");
  const [email, setEmail] = useState("");

  // prefill form when editing
  useEffect(() => {

    if (editingUser) {
      setName(editingUser.name);
      setEmail(editingUser.email);
    }

  }, [editingUser]);

  const handleSubmit = async (e) => {

    e.preventDefault();

    if (!name || !email) {
      alert("All fields are required");
      return;
    }

    const userData = {
      name,
      email
    };

    try {

      let response;

      // UPDATE USER
      if (editingUser) {

        response = await fetch(
          `http://localhost:8081/users/${editingUser.id}`,
          {
            method: "PUT",
            headers: {
              "Content-Type": "application/json"
            },
            body: JSON.stringify(userData)
          }
        );

      } else {

        // CREATE USER
        response = await fetch(
          "http://localhost:8081/users",
          {
            method: "POST",
            headers: {
              "Content-Type": "application/json"
            },
            body: JSON.stringify(userData)
          }
        );
      }

      if (!response.ok) {
        throw new Error("Operation failed");
      }

      const data = await response.json();

      console.log(data);

      // refresh list
      onUserCreated();

      // clear form
      setName("");
      setEmail("");

      // reset editing state
      setEditingUser(null);

    } catch (error) {
      console.error("Error:", error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>

      <h2>
        {editingUser ? "Edit User" : "Create User"}
      </h2>

      <input
        type="text"
        placeholder="Enter name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />

      <input
        type="email"
        placeholder="Enter email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />

      <button type="submit">
        {editingUser ? "Update User" : "Create User"}
      </button>

    </form>
  );
}

export default UserForm;
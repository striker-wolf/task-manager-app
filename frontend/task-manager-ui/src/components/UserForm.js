import React, {
  useEffect,
  useState
} from "react";

import {
  createUser,
  updateUser
} from "../services/userService";

function UserForm({
  onUserCreated,
  editingUser,
  setEditingUser
}) {

  const [name, setName] = useState("");
  const [email, setEmail] = useState("");

  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState("");
  const [error, setError] = useState("");

  useEffect(() => {

    if (editingUser) {

      setName(editingUser.name);
      setEmail(editingUser.email);

    }

  }, [editingUser]);

  const handleSubmit = async (e) => {

    e.preventDefault();

    if (!name || !email) {

      setMessage("");
      setError("All fields are required");

      return;
    }

    setLoading(true);
    setMessage("");
    setError("");

    const userData = {
      name,
      email
    };

    try {

      await new Promise(
        resolve => setTimeout(resolve, 3000)
      );

      let data;

      if (editingUser) {

        data = await updateUser(
          editingUser.id,
          userData
        );

      } else {

        data = await createUser(userData);

      }

      console.log(data);

      setMessage(
        editingUser
          ? "User updated successfully"
          : "User created successfully"
      );

      onUserCreated();

      setName("");
      setEmail("");

      setEditingUser(null);

    } catch (error) {

      console.error("Error:", error);

      setError(error.message);

    } finally {

      setLoading(false);

    }
  };

  return (
    <form onSubmit={handleSubmit}>

      <h2>
        {editingUser
          ? "Edit User"
          : "Create User"}
      </h2>

      <input
        type="text"
        placeholder="Enter name"
        value={name}
        onChange={(e) =>
          setName(e.target.value)
        }
      />

      <input
        type="email"
        placeholder="Enter email"
        value={email}
        onChange={(e) =>
          setEmail(e.target.value)
        }
      />

      <button
        type="submit"
        disabled={loading}
      >

        {loading
          ? "Processing..."
          : editingUser
            ? "Update User"
            : "Create User"}

      </button>

      {message && (
        <p style={{ color: "green" }}>
          {message}
        </p>
      )}

      {error && (
        <p style={{ color: "red" }}>
          {error}
        </p>
      )}

    </form>
  );
}

export default UserForm;
import React, { useEffect, useState } from "react";

function UserList({ refresh }) {

  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetchUsers();
  }, [refresh]);

  const fetchUsers = async () => {
    try {
      const response = await fetch("http://localhost:8081/users");
      const data = await response.json();
      setUsers(data.data);
    } catch (error) {
      console.error("Error fetching users:", error);
    }
  };

  const deleteUser = async (id) => {

    const confirmDelete = window.confirm("Are you sure you want to delete this user?");

    if (!confirmDelete) return;

    try {

      const response = await fetch(`http://localhost:8081/users/${id}`, {
        method: "DELETE"
      });

      if (!response.ok) {
        throw new Error("Failed to delete user");
      }

      // refresh list after deletion
      fetchUsers();

    } catch (error) {
      console.error("Error deleting user:", error);
    }
  };

  return (
    <div>
      <h2>Users</h2>

      {users.map(user => (
        <div key={user.id}>

          <p>
            {user.name} - {user.email}
          </p>

          <button onClick={() => deleteUser(user.id)}>
            Delete
          </button>

        </div>
      ))}
    </div>
  );
}

export default UserList;
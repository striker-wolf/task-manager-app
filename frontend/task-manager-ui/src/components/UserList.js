import React, { useEffect, useState } from "react";

import {
  getUsers,
  deleteUser
} from "../services/userService";

function UserList({ refresh, onEditUser }) {

  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetchUsers();
  }, [refresh]);

  const fetchUsers = async () => {

    try {

      const data = await getUsers();

      setUsers(data.data);

    } catch (error) {

      console.error(
        "Error fetching users:",
        error
      );

    }
  };

  const handleDeleteUser = async (id) => {

    const confirmDelete = window.confirm(
      "Are you sure you want to delete this user?"
    );

    if (!confirmDelete) return;

    try {

      await deleteUser(id);

      fetchUsers();

    } catch (error) {

      console.error(
        "Error deleting user:",
        error
      );

    }
  };

  return (
    <div>

      <h2>Users</h2>

      {users.map((user) => (

        <div key={user.id}>

          <p>
            {user.name} - {user.email}
          </p>

          <button
            onClick={() => onEditUser(user)}
          >
            Edit
          </button>

          <button
            onClick={() =>
              handleDeleteUser(user.id)
            }
          >
            Delete
          </button>

        </div>
      ))}

    </div>
  );
}

export default UserList;
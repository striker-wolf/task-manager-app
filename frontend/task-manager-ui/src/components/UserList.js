import React, { useEffect, useState } from "react";

function UserList() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8081/users")
      .then(res => res.json())
      .then(data => {
        setUsers(data.data); // because ApiResponse<T>
      });
  }, []);

  return (
    <div>
      <h2>Users</h2>
      {users.map(user => (
        <div key={user.id}>
          <p>{user.name} - {user.email}</p>
        </div>
      ))}
    </div>
  );
}

export default UserList;
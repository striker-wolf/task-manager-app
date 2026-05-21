import React, { useState } from "react";
import UserForm from "./components/UserForm";
import UserList from "./components/UserList";

function App() {

  const [refresh, setRefresh] = useState(false);

  // stores currently editing user
  const [editingUser, setEditingUser] = useState(null);

  // refresh users after create/update
  const handleUserCreated = () => {
    setRefresh(prev => !prev);
  };

  // set selected user for editing
  const handleEditUser = (user) => {
    setEditingUser(user);
  };

  return (
    <div>
      <h1>Task Manager</h1>

      <UserForm
        onUserCreated={handleUserCreated}
        editingUser={editingUser}
        setEditingUser={setEditingUser}
      />

      <UserList
        refresh={refresh}
        onEditUser={handleEditUser}
      />
    </div>
  );
}

export default App;
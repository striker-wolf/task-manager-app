import React, { useState } from "react";
import UserForm from "./components/UserForm";
import UserList from "./components/UserList";

function App() {

  const [refresh, setRefresh] = useState(false);

  const handleUserCreated = () => {
    setRefresh(prev => !prev);
  };

  return (
    <div>
      <h1>Task Manager</h1>

      <UserForm onUserCreated={handleUserCreated} />

      <UserList refresh={refresh} />
    </div>
  );
}

export default App;
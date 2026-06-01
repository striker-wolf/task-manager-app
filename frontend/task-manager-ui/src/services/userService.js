const BASE_URL = "http://localhost:8081/users";

export const getUsers = async () => {

  const response = await fetch(BASE_URL);

  if (!response.ok) {
    throw new Error("Failed to fetch users");
  }

  return response.json();
};

export const createUser = async (userData) => {

  const response = await fetch(BASE_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(userData)
  });

  const data = await response.json();

  if (!response.ok) {
    throw new Error(
      data.message || "Failed to create user"
    );
  }

  return data;
};

export const updateUser = async (id, userData) => {

  const response = await fetch(
    `${BASE_URL}/${id}`,
    {
      method: "PUT",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(userData)
    }
  );

  const data = await response.json();

  if (!response.ok) {
    throw new Error(
      data.message || "Failed to update user"
    );
  }

  return data;
};

export const deleteUser = async (id) => {

  const response = await fetch(
    `${BASE_URL}/${id}`,
    {
      method: "DELETE"
    }
  );

  if (!response.ok) {
    throw new Error("Failed to delete user");
  }

  return response.json();
};
import React from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

export default function LogoutButton() {
  const navigate = useNavigate();

  const handleLogout = async () => {
    try {
      await axios.post('http://localhost:8080/api/public/logout', {}, { withCredentials: true });
      navigate('/'); // Redirect to home page after logout
    } catch (error) {
      console.error('Logout failed:', error);
      // Optionally show a message to the user here
    }
  };

  return (
    <button onClick={handleLogout}>
      Logout
    </button>
  );
}
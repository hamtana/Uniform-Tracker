import React, { useState, useEffect, useMemo } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from '@/pages/home';
import ViewInventory from '@/pages/ViewInventory';
import Orders from '@/pages/orders';
import NotFound from '@/pages/NotFound';
import LoginModal from '@/components/LoginModal';

function App() {
  const [showLogin, setShowLogin] = useState(false);
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  // Check token on initial render
  useEffect(() => {
    const token = localStorage.getItem('token'); // or sessionStorage.getItem('token')
    setIsLoggedIn(!!token);
  }, []);

  return (
    <Router>
      {/* Show login button only if not logged in, place button on the right hand side */}
      {!isLoggedIn && (
        <button onClick={() => setShowLogin(true)} className="login-button">
          Login
        </button>
      )}

      <LoginModal
        isOpen={showLogin}
        onClose={() => setShowLogin(false)}
      />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/inventory" element={<ViewInventory />} />
        <Route path="/orders" element={<Orders />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </Router>
  );
}

export default App;

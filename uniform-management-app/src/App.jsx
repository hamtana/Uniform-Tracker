import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from '@/pages/home';
import ViewInventory from '@/pages/ViewInventory';
import Orders from '@/pages/orders';
import LoginModal from 'components/LoginModal';

function App() {
  const [showLogin, setShowLogin] = useState(false);

  return (
    <Router>
      {/* Login button and modal must be inside Router */}
      <button
        onClick={() => setShowLogin(true)}
        style={{ position: 'fixed', top: 10, right: 10, zIndex: 1100 }}
      >
        Login
      </button>

      <LoginModal isOpen={showLogin} onClose={() => setShowLogin(false)} />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/inventory" element={<ViewInventory />} />
        <Route path="/orders" element={<Orders />} />
      </Routes>
    </Router>
  );
}

export default App;

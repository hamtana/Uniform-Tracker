import React from 'react';
import { Routes, Route } from 'react-router-dom';
import ViewInventory from './pages/ViewInventory';

const Orders = () => <h2>Orders Page Coming Soon</h2>;

function AppRouter() {
  return (
    <Routes>
      <Route path="/inventory" element={<ViewInventory />} />
      <Route path="/orders" element={<Orders />} />
    </Routes>
  );
}

export default AppRouter;
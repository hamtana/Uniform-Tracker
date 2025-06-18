import React, { useEffect, useState } from 'react';
import { getInventory, updateQuantity } from '../services/inventoryService';
import InventoryTable from '../components/InventoryTable';
import EditInventoryModal from '../components/EditInventoryModal';
import SearchBar from '../components/SearchBar';
import '@/css/home.css';

export default function ViewInventory() {
  const [inventory, setInventory] = useState([]);
  const [editingItem, setEditingItem] = useState(null);
  const [searchTerm, setSearchTerm] = useState('');

useEffect(() => {
  getInventory()
    .then((res) => setInventory(res.data))
    .catch((err) => {
      if (err.response && err.response.status === 403) {
        window.location.href = '/'; // Redirect to home page
        alert('Access denied. Please login with proper credentials.');
      } else {
        console.error('Error fetching inventory:', err);
      }
    });
}, []);

  const handleSave = (id, quantity) => {
    updateQuantity(id, quantity).then(() => {
      setInventory((prev) =>
        prev.map((item) =>
          item.inventoryid === id ? { ...item, quantity_in_stock: quantity } : item
        )
      );
      setEditingItem(null);
    });
  };

  const filteredInventory = inventory.filter(item =>
    item.name.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <div>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
        <h1>View Inventory</h1>
      </div>
      <SearchBar searchTerm={searchTerm} onSearch={setSearchTerm} />
      <InventoryTable inventory={filteredInventory} onEdit={setEditingItem} />
      {editingItem && (
        <EditInventoryModal
          item={editingItem}
          onClose={() => setEditingItem(null)}
          onSave={handleSave}
        />
      )}
    </div>
  );
}

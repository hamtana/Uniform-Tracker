import React, { useEffect, useState } from 'react';
import { getInventory, updateQuantity } from '../services/inventoryService';
import InventoryTable from '../components/InventoryTable';
import EditInventoryModal from '../components/EditInventoryModal';
import SearchBar from '../components/SearchBar';

//css

export default function ViewInventory() {
  const [inventory, setInventory] = useState([]);
  const [editingItem, setEditingItem] = useState(null);
  const [searchTerm, setSearchTerm] = useState('');

  useEffect(() => {
    getInventory().then((res) => setInventory(res.data));
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

  //Filtering the inventory by name
  const filteredInventory = inventory.filter(item => 
    item.name.toLowerCase().includes(searchTerm.toLowerCase())
);


  return (
    <div>
      <h1>View Inventory</h1>
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
};



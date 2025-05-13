import React, { useEffect, useState } from 'react';
import { getInventory, updateQuantity } from '../services/inventoryService';
import InventoryTable from '../components/InventoryTable';
import EditInventoryModal from '../components/EditInventoryModal';
import SearchBar from '../components/SearchBar';
import '../ViewInventory.css'; //css


//Function will show the inventory items currently in the database.
// Provides functionality for editing an item in the inventory and filtering to search the inventory. 
export default function ViewInventory() {
  const [inventory, setInventory] = useState([]);
  const [editingItem, setEditingItem] = useState(null);
  const [searchTerm, setSearchTerm] = useState('');

  //Retrieves the inventory from the back-end.
  useEffect(() => {
    getInventory().then((res) => setInventory(res.data));
  }, []);

  //Saves the changes made to the quantity of items in stock.
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



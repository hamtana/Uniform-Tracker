import React, { useEffect, useState } from 'react';
import { getInventory, updateQuantity } from '../services/inventoryService';
import InventoryTable from '../components/InventoryTable';
import EditInventoryModal from '../components/EditInventoryModal';

export default function ViewInventory() {
  const [inventory, setInventory] = useState([]);
  const [editingItem, setEditingItem] = useState(null);

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

  return (
    <div>
      <h1>View Inventory</h1>
      <InventoryTable inventory={inventory} onEdit={setEditingItem} />
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



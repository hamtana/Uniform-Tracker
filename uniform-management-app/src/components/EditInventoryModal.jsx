import React, { useState } from 'react';
import axios from 'axios';

//Modal popup that allows the user to edit the inventory within the same screen, without loading a new page. 

export default function EditInventoryModal({ item, onClose, onSave }) {
  const [quantity, setQuantity] = useState(item.quantity_in_stock);

const handleSubmit = () => {
  if (isNaN(quantity) || quantity < 0) {
    alert('Please enter a valid quantity');
    return;
  }
  if (quantity === '') {
    alert('Please enter a quantity');
    return;
  }
  if (quantity === item.quantity_in_stock) {
    alert('No changes made to the quantity');
    return;
  }

  const updateInventory = async () => {
    try {
      const response = await axios.put(
        `http://localhost:8080/api/inventory/${item.inventoryid}`,
        { quantity_in_stock: quantity }
      );
      console.log('Update successful:', response.data);
      onSave(item.inventoryid, quantity);
    } catch (error) {
      console.error('Error updating inventory:', error);
    }
  };

  updateInventory();
};



  return (
    <div className="modal-overlay">
      <div className="modal-content">
        <h2>Quantity for {item.name}</h2>
        <input
          type="number"
          value={quantity}
          onChange={(e) => setQuantity(e.target.value)}
        />
        <div style={{ marginTop: '10px' }}>
          <button onClick={handleSubmit}>Save</button>
          <button onClick={onClose} style={{ marginLeft: '10px' }}>Cancel</button>
        </div>
      </div>
    </div>
  );
}

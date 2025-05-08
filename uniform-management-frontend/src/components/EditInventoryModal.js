import React, { useState } from 'react';

export default function EditInventoryModal({ item, onClose, onSave }) {
  const [quantity, setQuantity] = useState(item.quantity_in_stock);

  const handleSubmit = () => {
    onSave(item.inventoryid, parseInt(quantity, 10)); // Make sure it's a number
  };

  return (
    <div className="modal">
      <h2>Quantity for {item.name}</h2>
      <input
        type="number"
        value={quantity}
        onChange={(e) => setQuantity(e.target.value)}
      />
      <button onClick={handleSubmit}>Save</button>
      <button onClick={onClose}>Cancel</button>
    </div>
  );
}

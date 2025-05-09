import React, { useState } from 'react';

export default function EditInventoryModal({ item, onClose, onSave }) {
  const [quantity, setQuantity] = useState(item.quantity_in_stock);

  const handleSubmit = () => {
    onSave(item.inventoryid, parseInt(quantity));
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

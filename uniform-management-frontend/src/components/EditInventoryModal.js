import React, { useState } from 'react';

export default function EditInventoryModal({item, onClose, onSave}) {
    const [quantity, setQuantity] = useSate(item.quantity_in_stock);

    const handleSubmit = () => {
        onSave(item.inventoryid, quantity_in_stock)
    };

    return(
        <div classname="modal">
            <h2>Quantity for {item.name}</h2>
            <input type="number" value={quantity_in_stock} onChange={(e) => setQuantity(e.target.value)}/>
            <button onClick={handleSubmit}>Save</button>
            <button onClick={onClose}>Cancel</button>
        </div>
    );
}
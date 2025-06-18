import React from 'react';

//Inventory table component that is added to the main ViewInventory Page

export default function InventoryTable({inventory, onEdit}){
    return (
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Cost</th>
                    <th>Size</th>
                    <th>Quantity in Stock</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
        {inventory.map(item => (
          <tr key={item.inventoryid}>
            <td>{item.inventoryid}</td>
            <td>{item.name}</td>
            <td>{item.cost}</td>
            <td>{item.size}</td>
            <td>{item.quantity_in_stock}</td>
            <td>
              <button onClick={() => onEdit(item)}>Edit</button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

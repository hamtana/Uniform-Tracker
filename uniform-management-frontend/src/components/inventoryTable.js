import React from 'react';

export default function InventoryTable({inventory, onEdit}){
    return (
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Serial</th>
                    <th>Cost</th>
                    <th>Size</th>
                    <th>Quantity in Stock</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
        {inventory.map((item) => (
          <tr key={item.id}>
            <td>{item.inventoryid}</td>
            <td>{item.name}</td>
            <td>{item.serial}</td>
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

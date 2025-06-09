import axios from 'axios';

const API_BASE = "http://localhost:8080/api/inventory";

// Get the entire inventory
export const getInventory = () => axios.get(API_BASE, {withCredentials: true,});

// Update quantity of an inventory item
export const updateQuantity = async (inventoryid, quantity) => {
  try {
    // Get the current inventory item
    const response = await axios.get(`${API_BASE}/${inventoryid}`);
    const currentInventory = response.data;

    // Update the quantity_in_stock (while keeping other fields the same)
    const updatedInventory = {
      ...currentInventory, // Spread current inventory fields
      quantity_in_stock: quantity, // Only update the quantity
    };

    // Send the updated inventory object back to the server
    return axios.put(`${API_BASE}/${inventoryid}`, updatedInventory);
  } catch (error) {
    console.error("Error updating quantity:", error);
  }
  
};

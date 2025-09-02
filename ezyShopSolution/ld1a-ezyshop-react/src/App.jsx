import { useEffect, useState } from "react";
import "./App.css";

const API = "http://localhost:8081/api/products";

export default function App() {
  const empty = { productId: "", name: "", description: "", category: "", price: "" };
  const [items, setItems] = useState([]);
  const [form, setForm] = useState(empty);

  const load = () => fetch(API).then(r => r.json()).then(setItems);

  useEffect(() => { load(); }, []);

  const onChange = (e) => setForm({ ...form, [e.target.name]: e.target.value });

  const onSubmit = (e) => {
    e.preventDefault();
    const payload = { ...form, price: parseFloat(form.price || 0) };
    if (!form.productId) {
      // create
      fetch(API, { method: "POST", headers: { "Content-Type": "application/json" }, body: JSON.stringify(payload) })
        .then(r => r.json()).then(() => { setForm(empty); load(); });
    } else {
      // update
      fetch(`${API}/${form.productId}`, { method: "PUT", headers: { "Content-Type": "application/json" }, body: JSON.stringify(payload) })
        .then(r => r.json()).then(() => { setForm(empty); load(); });
    }
  };

  const onEdit = (p) => setForm({ ...p, price: String(p.price) });

  const onDelete = (id) => {
    fetch(`${API}/${id}`, { method: "DELETE" }).then(() => load());
  };

  const onCancel = () => setForm(empty);

  return (
    <div className="container">
      <h1>ezyShop Products</h1>

      <form className="form" onSubmit={onSubmit}>
        <input name="name" placeholder="Name" value={form.name} onChange={onChange} required />
        <input name="description" placeholder="Description" value={form.description} onChange={onChange} />
        <input name="category" placeholder="Category" value={form.category} onChange={onChange} />
        <input name="price" type="number" step="0.01" placeholder="Price" value={form.price} onChange={onChange} required />
        <button type="submit">{form.productId ? "Update" : "Add"}</button>
        {form.productId && <button type="button" onClick={onCancel}>Cancel</button>}
      </form>

      <table className="table">
        <thead>
          <tr>
            <th>ID</th><th>Name</th><th>Category</th><th>Price</th><th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {items.map(p => (
            <tr key={p.productId}>
              <td>{p.productId}</td>
              <td>{p.name}</td>
              <td>{p.category}</td>
              <td>{p.price}</td>
              <td>
                <button onClick={() => onEdit(p)}>Edit</button>
                <button onClick={() => onDelete(p.productId)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
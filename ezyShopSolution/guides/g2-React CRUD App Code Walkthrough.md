---

### :rocket: React CRUD App Code Walkthrough

#### :bulb: Imports

```js
import { useEffect, useState } from "react";
import "./App.css";
```

- **useState** → for managing component state.
- **useEffect** → for running side effects (like fetching data).
- **App.css** → CSS stylesheet for styling.

---

#### :gear: API Endpoint

```js
const API = "http://localhost:8081/api/products";
```

- **API**: Base URL of your backend API for products.

---

#### :dart: Main Component

```js
export default function App() {
  // ...existing code...
}
```

- Declares your main React component `App` and exports it as the default export.

---

#### :brain: State Management

```js
const empty = { productId: "", name: "", description: "", category: "", price: "" };
const [items, setItems] = useState([]);
const [form, setForm] = useState(empty);
```

- **empty**: Template object for a blank product (used to reset the form or initialize state).
- **items**: State array holding all products fetched from the backend.
- **form**: State object representing the current form inputs.

---

#### :triangular_ruler: Data Loading

```js
const load = () => fetch(API).then(r => r.json()).then(setItems);
useEffect(() => { load(); }, []);
```

- **load**: Fetches all products from API, parses as JSON, updates `items` state.
- **useEffect**: Runs once after the component mounts, calls `load()` to fetch the product list at startup.

---

#### :gear: Form Handling

```js
const onChange = (e) => setForm({ ...form, [e.target.name]: e.target.value });
```

- Updates the form state whenever an input changes.

---

#### :test_tube: Form Submission

```js
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
```

- **onSubmit**: Handles form submission for both create and update.
  - **POST** if `productId` is empty (create).
  - **PUT** if `productId` is present (update).
  - Resets form and reloads product list after success.

---

#### :bulb: Edit & Delete

```js
const onEdit = (p) => setForm({ ...p, price: String(p.price) });
const onDelete = (id) => {
  fetch(`${API}/${id}`, { method: "DELETE" }).then(() => load());
};
const onCancel = () => setForm(empty);
```

- **onEdit**: Loads product into form for editing.
- **onDelete**: Removes a product via API and reloads list.
- **onCancel**: Resets form to its empty template.

---

#### :white_check_mark: JSX (UI Rendering)

```jsx
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
```

- **Form**: Controlled inputs bound to form state.
- **Table**: Lists all products with Edit and Delete actions.

---

### :white_check_mark: Summary

- **Simple CRUD React app**:
  - Fetches and lists products from a backend.
  - Lets you add, edit, delete products.
  - Uses controlled form inputs with `useState`.
  - Uses `fetch` for all API calls.
  - :rocket: **Automatically reloads the product list after every change.**

---
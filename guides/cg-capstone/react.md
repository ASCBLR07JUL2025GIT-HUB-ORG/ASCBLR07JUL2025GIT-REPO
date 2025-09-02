``` js
import { useEffect, useState } from "react";

function App() {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8081/api/products")
            .then((res) => res.json())
            .then((data) => setProducts(data))
            .catch((err) => console.error("Error fetching products:", err));
    }, []);

    return (
        <div>
            <h1>Products</h1>
            <ul>
                {products.map((p) => (
                    <li key={p.productId}>
                        {p.productId} - {p.name} ({p.category}) : {p.price}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default App;
```
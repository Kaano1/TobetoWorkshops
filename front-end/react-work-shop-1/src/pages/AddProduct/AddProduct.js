import { useState } from "react";
import "bootstrap/dist/css/bootstrap.css";
import axios from "axios";

function freeValue(props) {
  props.title = "";
  props.description = "";
  props.price = 0;
  props.discountPercentage = 0;
  props.rating = 0;
  props.stock = 0;
  props.brand = "";
  props.category = "";
  props.thumbnail = "";
  props.images = [];
}

function AddProduct() {
  var props = JSON.parse(localStorage.getItem("products"));
  const [newProduct, setNewProduct] = useState({
    id: props.length + 1,
    title: "",
    description: "",
    price: 0,
    discountPercentage: 0,
    rating: 0,
    stock: 0,
    brand: "",
    category: "",
    thumbnail: "",
    images: [],
  });
  let control = [];

  const handleInput = (e) => {
    const { name, value } = e.target;
    setNewProduct((prevProduct) => ({
      ...prevProduct,
      [name]: value,
    }));
  };

  const saveProduct = async () => {
    console.log(props);
    try {
      await axios.post("https://dummyjson.com/products/add", newProduct);
    } catch (error) {
      alert("Axios Post Error:", error);
    }
    props.push(newProduct);
    localStorage.setItem("products", JSON.stringify(props));
    freeValue(newProduct);
  };

  return (
    <>
      <div>
        <div className="d-flex justify-content-center">
          <h1>Product Add</h1>
        </div>
        <br />
        <div className="d-flex justify-content-center">
          <input
            name="title"
            value={newProduct.title}
            type="text"
            onChange={(e) => handleInput(e)}
            placeholder="Product Name: "
          />
        </div>
        <br />
        <div className="d-flex justify-content-center">
          <textarea
            name="description"
            value={newProduct.description}
            type="text"
            onChange={handleInput}
            placeholder="Product Description: "
          />
        </div>
        <br />
        <div className="d-flex justify-content-center">
          <select
            name="category"
            value={newProduct.category}
            onChange={handleInput}
          >
            <option disabled>Select Category</option>
            {props.map((product) => {
              if (control.includes(product.category) === false) {
                control.push(product.category);
                return (
                  <option key={product.category}>{product.category}</option>
                );
              }
              return null;
            })}
          </select>
        </div>
        <br />
        <div className="d-flex justify-content-center">
          <select name="brand" value={newProduct.brand} onChange={handleInput}>
            <option disabled>Select Brand</option>
            {props.map((product) => {
              if (control.includes(product.brand) === false) {
                control.push(product.brand);
                return <option key={product.brand}>{product.brand}</option>;
              }
              return null;
            })}
          </select>
        </div>
        <br />
        <div className="d-flex justify-content-center">
          <input
            name="price"
            value={newProduct.price}
            type="number"
            onChange={handleInput}
            placeholder="Product Price: "
          />
        </div>
        <br />
        <div className="d-flex justify-content-center">
          <input
            name="stock"
            type="number"
            value={newProduct.stock}
            onChange={handleInput}
            placeholder="Product Stock: "
          />
        </div>
        <br />
        <div className="d-flex justify-content-center">
          <input
            name="thumbnail"
            value={newProduct.thumbnail}
            onChange={handleInput}
            type="file"
          />
        </div>
        <br />
        <div className="d-flex justify-content-center">
          <button type="submit" onClick={() => saveProduct()}>
            Add Product
          </button>
        </div>
      </div>
    </>
  );
}

export default AddProduct;

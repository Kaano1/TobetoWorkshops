import React, { useState, useEffect } from "react";
import ProductCard from "../../component/ProductCard/ProductCard";
import { useNavigate } from "react-router-dom";

function Products() {
  const history = useNavigate();
  const [products, setProducts] = useState([]);

  useEffect(() => {
	  setProducts(JSON.parse(localStorage.getItem("products")));
  }, []);
  console.log(products);

  const handleDelete = (id) => {
    setProducts(() => products.filter((product) => product.id !== id));
	localStorage.setItem("products", JSON.stringify(products));
  };

  const handleClick = () => {
    history("../add/product");
  };

  return (
    <>
      <button className="btn btn-primary" onClick={handleClick}>
        Ürün Ekle
      </button>
      <div className="container mt-5">
        <div className="row">
          {products.map((product) => (
            <div
              key={product.id}
              className="col col-sm-12 col-md-6 col-lg-3 col-xl-3 col-xxl-2 mb-3"
            >
              <ProductCard product={product} deleteHandle={handleDelete} />
            </div>
          ))}
        </div>
      </div>
    </>
  );
}

export default Products;

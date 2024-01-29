import React from "react";
import { useParams } from "react-router-dom";

function Detail() {
	const { id } = useParams();
	const props = JSON.parse(localStorage.getItem("products"));
	var product;
	
	props.map((pr) => {
		if (pr.id == id) {
			product = pr;
		}
	});
	console.log(product);

  return (
    <div>
      <div className="row">
        <div className="col-2">
          <img
            src={product.thumbnail}
            className="img-fluid border border-4 border-warning rounded m-5"
            style={{ height: "200px" }}
          />
        </div>
        <div className="col-8 p-5 mx-4 my-2">
          <p className="fw-medium">{product.title}</p>
          <p>
            {product.description}
          </p>
          <br />
          <br />
          <div className="row">
            <div className="col-4">
              <p className="mx-4">Brand: {product.brand}</p>
            </div>
            <div className="col-5">
              <p className="mx-4">Category:  {product.category}</p>
            </div>
          </div>
          <div className="row">
            <div className="col-4">
              <p className="mx-4">Stock: {product.stock}</p>
            </div>
            <div className="col-4">
              <p className="mx-4">Price: {product.price}</p>
            </div>
          </div>
        </div>
      </div>

      <div></div>
    </div>
  );
}

export default Detail;

import "./App.css";
import { useState } from "react";
import "bootstrap/dist/css/bootstrap.css"
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Homepage from "./pages/Homepage/Homepage";
import Products from "./pages/Products/Products";
import Detail from "./pages/Detail/Detail";
import AddProduct from "./pages/AddProduct/AddProduct";


function App() {
  return <BrowserRouter>
    <Routes>
      <Route path="/" element={<Homepage></Homepage>}></Route>
      <Route path="/products" element={<Products></Products>}></Route>
      <Route path='/products/:id' element={<Detail></Detail>}></Route>
      <Route path="/add/product" element={<AddProduct></AddProduct>}></Route>
    </Routes>
  </BrowserRouter>
    
}

export default App;

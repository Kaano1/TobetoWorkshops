import axios from "axios";

function Homepage()
{
	let pass = true;

	const axiosGet = async () => {
		try {
		  const response = await axios.get("https://dummyjson.com/products");
		  localStorage.setItem("products", JSON.stringify(response.data.products));
		  pass = false;
		} catch (error) {
		  console.error("Axios Get Hatası:", error);
		}
	  };
	axiosGet();
	return <>
		<h1>Homepage</h1>
	</>
}

export default Homepage;
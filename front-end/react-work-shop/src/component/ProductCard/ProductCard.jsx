function ProductCard(props)
{
	return (<>
		<div className="card">
			<img src={props.product.thumbnail} className="card-img-top" alt="..." />
			<div className="card-body">
				<h5 className="card-title">{props.product.title}</h5>
				<p className="card-text">{props.product.description}</p>
				<a href={"/products/" + props.product.id} className="btn btn-primary">Detail</a>
				<button className="btn btn-danger" onClick={() => props.deleteHandle(props.product.id)} >delete</button>
			</div>
		</div>
	</>);
}

export default ProductCard;
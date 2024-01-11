import "./App.css";
import { useState } from "react";

function App() {
  const [todoList, setLine] = useState([]);
  const [add, setValue] = useState("");

  const addLine = (event) => {
    setValue(event.target.value);
  };

  const sendLine = () => {
    setLine([...todoList, add]);
    setValue("")
  };

  return (
    <>
      <div>
        <h1>TO_DO List</h1>
        <p>add new task</p>
        <input type="text" value={add} onChange={addLine} />
        <button onClick={sendLine}>accept</button>
        <hr />
        <ul>
          {todoList.map((element) => <li key={element}>{element}</li>)}
        </ul>
      </div>
    </>
  );
}

export default App;

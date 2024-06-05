import React, { useState } from 'react';
import AddCat from './components/AddCat';
import CatList from './components/CatList';
import UpdateCat from './components/UpdateCat';

function App() {
  const [fetchCats, setFetchCats] = useState(() => () => {});

  return (
    <div className="App">
      <h1>Gerenciamento de cachorros</h1>
      <AddCat fetchCats={fetchCats} />
      <UpdateCat fetchCats={fetchCats} />
      <CatList setFetchCats={setFetchCats} />
    </div>
  );
}

export default App;

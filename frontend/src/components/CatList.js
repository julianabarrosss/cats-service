import React, { useState, useEffect } from 'react';
import axios from 'axios';

const CatList = ({ setFetchCats }) => {
  const [cats, setCats] = useState([]);

  const fetchCats = async () => {
    try {
      const response = await axios.get('http://18.222.248.95:8080/cat');
      console.log(response.data);
      setCats(response.data);
    } catch (error) {
      console.error('Error fetching cats:', error);
    }
  };

  useEffect(() => {
    fetchCats();
    setFetchCats(() => fetchCats);
  }, [setFetchCats]);

  return (
    <div>
      <h2>Lista de Gatos</h2>
      <ul>
        {cats.map((cat) => (
          <li key={cat.id}>
            {cat.name} - {cat.breed} - {cat.birth}
            <button onClick={() => {
              document.getElementById('update-id').value = cat.id;
              document.getElementById('update-name').value = cat.name;
              document.getElementById('update-breed').value = cat.breed;
              document.getElementById('update-birth').value = cat.birth;
            }}>Atualizar</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CatList;

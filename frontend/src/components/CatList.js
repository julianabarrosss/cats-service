import React, { useState, useEffect } from 'react';
import axios from 'axios';

const CatList = () => {
  const [cats, setCats] = useState([]);

  useEffect(() => {
    const fetchCats = async () => {
      try {
        const response = await axios.get('http://13.59.64.213:8080/cat');
        setCats(response.data);
      } catch (error) {
        console.error('Error fetching cats:', error);
      }
    };

    fetchCats();
  }, []);

  return (
    <div>
      <h2>Lista de Gatos</h2>
      <ul>
        {cats.map((cat) => (
          <li key={cat.id}>{cat.nome} - {cat.breed} - {cat.birth}</li>
        ))}
      </ul>
    </div>
  );
};

export default CatList;

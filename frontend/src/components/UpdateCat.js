import React, { useState } from 'react';
import axios from 'axios';

const UpdateCat = ({ fetchCats }) => {
  const [id, setId] = useState('');
  const [name, setName] = useState('');
  const [breed, setBreed] = useState('');
  const [birth, setBirth] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.put(`http://18.118.99.172:8080/cat/${id}`, { name, breed, birth });
      console.log(response.data);
      // Limpar os campos após o envio
      setId('');
      setName('');
      setBreed('');
      setBirth('');
      // Atualize a lista de gatos
      fetchCats();
    } catch (error) {
      console.error('Error updating cat:', error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>ID:</label>
        <input type="text" id="update-id" value={id} onChange={(e) => setId(e.target.value)} />
      </div>
      <div>
        <label>Nome:</label>
        <input type="text" id="update-name" value={name} onChange={(e) => setName(e.target.value)} />
      </div>
      <div>
        <label>Raça:</label>
        <input type="text" id="update-breed" value={breed} onChange={(e) => setBreed(e.target.value)} />
      </div>
      <div>
        <label>Data de Nascimento:</label>
        <input type="date" id="update-birth" value={birth} onChange={(e) => setBirth(e.target.value)} />
      </div>
      <button type="submit">Atualizar Gato</button>
    </form>
  );
};

export default UpdateCat;

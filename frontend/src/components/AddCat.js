import React, { useState } from 'react';
import axios from 'axios';

const AddCat = () => {
  const [nome, setNome] = useState('');
  const [breed, setBreed] = useState('');
  const [birth, setBirth] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://18.222.248.95:8080/cat', { nome, breed, birth });
      console.log(response.data);
      // Limpar os campos após o envio
      setNome('');
      setBreed('');
      setBirth('');
    } catch (error) {
      console.error('Error creating cat:', error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Nome:</label>
        <input type="text" value={nome} onChange={(e) => setNome(e.target.value)} />
      </div>
      <div>
        <label>Raça:</label>
        <input type="text" value={breed} onChange={(e) => setBreed(e.target.value)} />
      </div>
      <div>
        <label>Data de Nascimento:</label>
        <input type="date" value={birth} onChange={(e) => setBirth(e.target.value)} />
      </div>
      <button type="submit">Adicionar Gato</button>
    </form>
  );
};

export default AddCat;

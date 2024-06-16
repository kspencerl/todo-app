import React, { useState } from 'react';
import axios from 'axios';

const TodoForm = ({ onTaskAdded }) => {
  const [taskName, setTaskName] = useState('');

  const handleSubmit = (event) => {
    event.preventDefault();
    axios.post('/api/tasks/add', { name: taskName })
      .then(response => {
        onTaskAdded(response.data);
        setTaskName('');
      })
      .catch(error => {
        console.error('Erro ao adicionar tarefa!', error);
      });
  };

  return (
    <form className='TodoForm' onSubmit={handleSubmit}>
      <input 
        type='text' 
        className='todo-input' 
        placeholder='Qual sua nova tarefa?' 
        value={taskName}
        onChange={(e) => setTaskName(e.target.value)}
      />
      <button type='submit' className='todo-btn'>+</button>
    </form>
  );
}

export default TodoForm;

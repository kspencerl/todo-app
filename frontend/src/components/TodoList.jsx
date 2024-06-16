import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faTrash } from '@fortawesome/free-solid-svg-icons';

const TodoList = () => {
  const [tasks, setTasks] = useState([]);

  useEffect(() => {
    axios.get('/api/tasks') 
      .then(response => {
        setTasks(response.data);
      })
      .catch(error => {
        console.error("Erro ao buscar tarefas!", error);
      });
  }, []);

  const deleteTask = (id) => {
    axios.delete(`/api/tasks/${id}`)  
      .then(() => {
        setTasks(tasks.filter(task => task.id !== id));
      })
      .catch(error => {
        console.error("Erro ao deletar tarefa!", error);
      });
  };

  return (
    <div className='Todo'>
      {tasks.map(task => (
        <div key={task.id} className='Todo'>
          <p className='completed'>{task.name}</p>
          <div>
            <FontAwesomeIcon className='delete-icon' icon={faTrash} onClick={() => deleteTask(task.id)} />
          </div>
        </div>
      ))}
    </div>
  );
};

export default TodoList;

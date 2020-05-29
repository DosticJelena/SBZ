import React from 'react';
import './Modal.css';
import Backdrop from '../Backdrop/Backdrop';

const SmallModal = (props) => (
    <div>
        <Backdrop show={props.show} click={props.modalClosed} />
        <div 
            style={{
                transform: props.show ? 'translateY(0)' : 'translateY(-100vh)',
                opacity: props.show ? '1' : '0'
            }}
            className='SmallModal'>
            {props.children}
        </div>
    </div>
);

export default SmallModal;
import React from 'react'
import TextField from 'material-ui/core/TextField';
import axios from 'axios'
import './App.css'

class Login extends React.Component {
    render() {
        return (
            <div>
              <h2>Login</h2>
              <TextField
              hintText="Enter your Username"
              floatingLabelText="Username"
              />
       <br/>
            </div>
        );
    }
}

export default Login;  
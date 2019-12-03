import React, { Component } from "react";
import MuiThemeProvider from "material-ui/styles/MuiThemeProvider";
import AppBar from "material-ui/AppBar";
import RaisedButton from "material-ui/RaisedButton";
import TextField from "material-ui/TextField";
import axios from "axios";
import { Alert } from "reactstrap";
class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: "",
      name: "",
      password: ""
    };
  }
  handleClick(event) {
    var apiBaseUrl = "http://localhost:8080/";
    var payload = {
      id: this.state.id,
      name: this.state.name,
      password: this.state.password
    };
    axios.post(apiBaseUrl + "user", payload).then(response => {
      if (response.data != -1) {
        console.log(response);
        alert("added user");
      }
    });
    window.location.reload(true);
    //this.setState({id:'',name:'',password:''})
  }
  render() {
    return (
      <div>
        <MuiThemeProvider>
          <div>
            <AppBar title="Register" />
            <form>
              <TextField
                hintText="Enter your id"
                floatingLabelText="id"
                value={this.state.id}
                onChange={(event, newValue) => this.setState({ id: newValue })}
              />
              <br />
              <TextField
                hintText="Enter your Name"
                floatingLabelText="Name"
                value={this.state.name}
                onChange={(event, newValue) =>
                  this.setState({ name: newValue })
                }
              />
              <br />
              <TextField
                type="password"
                hintText="Enter your Password"
                floatingLabelText="Password"
                value={this.state.password}
                onChange={(event, newValue) =>
                  this.setState({ password: newValue })
                }
              />
              <br />
              <RaisedButton
                label="register"
                primary={true}
                style={style}
                onClick={event => this.handleClick(event)}
              />
            </form>
            <br />
            <h6>Already Registed ? Login now</h6>
            <RaisedButton
              label="log in"
              primary={true}
              style={style}
              onClick={event => this.props.handle(event)}
            />
          </div>
        </MuiThemeProvider>
      </div>
    );
  }
}
const style = {
  margin: 15
};

export default Register;

import React from "react";
import MuiThemeProvider from "material-ui/styles/MuiThemeProvider";
import AppBar from "material-ui/AppBar";
import RaisedButton from "material-ui/RaisedButton";
import TextField from "material-ui/TextField";
import axios from "axios";
import Words from "./Words";
import Register from "./Register";

class Login extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      reg: 1,
      id: -1,
      name: "",
      password: ""
    };
  }

  handleClick(event) {
    var apiBaseUrl = "http://localhost:8080/";
    var payload = {
      id: -1,
      name: this.state.name,
      password: this.state.password
    };
    axios.post(apiBaseUrl + "auth", payload).then(response => {
      if (response.data !== -1) {
        console.log(response);
        this.setState({ id: response.data });
      }
    });
  }

  handleClick2(event) {
    if (this.state.reg === 1) this.setState({ reg: 0 });
    else this.setState({ reg: 1 });
  }

  render() {
    var login = (
      <div>
        <MuiThemeProvider>
          <div>
            <AppBar title="Login" onLeftIconButtonClick={() => alert("left")} />
            <div></div>
            <TextField
              hintText="Enter your Username"
              floatingLabelText="Username"
              onChange={(event, newValue) => this.setState({ name: newValue })}
            />
            <br />
            <TextField
              type="password"
              hintText="Enter your Password"
              floatingLabelText="Password"
              onChange={(event, newValue) =>
                this.setState({ password: newValue })
              }
            />
            <br />
            <RaisedButton
              label="log in"
              primary={true}
              style={style}
              onClick={event => this.handleClick(event)}
            />
            <br />
            <h6>Not Registed ? Register now</h6>
            <RaisedButton
              label="Register"
              primary={true}
              style={style}
              onClick={event => this.handleClick2(event)}
            />
          </div>
        </MuiThemeProvider>
      </div>
    );
    if (this.state.id === -1) {
      if (this.state.reg === 0)
        return (
          <div>
            <Register handle={event => this.handleClick2(event)} />
          </div>
        );
      else return <div>{login}</div>;
    } else {
      return (
        <div>
          <Words id={this.state.id} />
        </div>
      );
    }
  }
}
const style = {
  margin: 15
};
export default Login;

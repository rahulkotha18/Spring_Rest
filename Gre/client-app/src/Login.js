import React from 'react'
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';
import axios from 'axios'
import UploadScreen from './UploadScreen'
class Login extends React.Component {
constructor(props){
  super(props);
  this.state={
  name:'',
  password:'',
  flag:true
  }
 }

 handleClick(event){
    var apiBaseUrl = "http://localhost:8080/";
    var self = this;
    var payload={
      "id":-1,
      "name":this.state.name,
      "password":this.state.password
    }
    axios.post(apiBaseUrl+'auth', payload)
    .then(function (response) {
    console.log(response);
    if(response.data !=-1){
    console.log("Login successfull");
    var uploadScreen=[];
    uploadScreen.push(<UploadScreen  id={response.data} appContext={self.props.appContext}/>)
    self.props.appContext.setState({loginPage:[],uploadScreen:uploadScreen})
    }
    else if(response.status == 404){
    console.log("Username password do not match");
    alert("username password do not match")
    }
    else{
    console.log("Username does not exists");
    alert("Username does not exist");
    }
    })
    .catch(function (error) {
    console.log(error);
    });
    }

render() {
    return (
      <div>
        <MuiThemeProvider>
          <div>
          <AppBar
             title="Login"
           />
           <TextField
             hintText="Enter your Username"
             floatingLabelText="Username"
             onChange = {(event,newValue) => this.setState({name:newValue})}
             />
           <br/>
             <TextField
               type="password"
               hintText="Enter your Password"
               floatingLabelText="Password"
               onChange = {(event,newValue) => this.setState({password:newValue})}
               />
             <br/>
             <RaisedButton label="Submit" primary={true} style={style} onClick={(event) => this.handleClick(event)}/>
         </div>
         </MuiThemeProvider>
      </div>
    );
  }
}
const style = {
 margin: 15,
};
export default Login;
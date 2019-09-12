import React, { Component } from 'react';
import axios from 'axios'
import { tsConstructorType } from '@babel/types';
import {Spinner,Navbar,NavbarBrand} from 'reactstrap'
import { Button,Box } from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';
class UploadScreen extends Component {
    constructor(props)
    {
        super(props)
        this.state={
            learnt:true,
            all:[],
            custom:[]

        }
    }
    componentDidMount()
    {
        axios.get("http://localhost:8080/words")
        .then(response=>
            {
                
                this.setState({all:response.data})
                
            })
            var url="http://localhost:8080/user/"+this.props.id
            axios.get(url)
        .then(response=>
            {
                
                this.setState({custom:response.data})
                
            })
        }
    changeState=()=>
    {
        if(this.state.learnt==true)
        this.setState({learnt:false})
        else
        {
        this.setState({learnt:true})
        }
    }
    words=(x)=> {
             return(
            <div>
            <div>
  <Navbar color="grey" dark expand="md">
      <NavbarBrand text-color="white">
      <Spinner type="grow" color="primary" />
      <Spinner type="grow" color="secondary" />
      <Spinner type="grow" color="success" />
      <Spinner type="grow" color="danger" />
      <Spinner type="grow" color="warning" />
      <Spinner type="grow" color="info" />
      <Spinner type="grow" color="dark" />
      </NavbarBrand>
  </Navbar>
  </div>
            <ul className="list-group">
            {x.map(data=>{
                return (
                    <div>
                <li class="list-group-item list-group-item-success" align="left">{data.word}</li>
                <li class="list-group-item list-group-item-success" align="justified">{data.meaning}</li>
                <li class="list-group-item list-group-item-light"></li>
                </div>
                );

            })}
            </ul>
        </div>
             )
        }
    render() {
        return (
            <div>
                <div>
                    <Box m={2}/>
                    <h2>Welcome</h2>
                </div>
                <div className="Pad"> 
                <Button onClick={this.changeState} variant="contained" color="primary">
                    Show words      </Button>
                <Button onClick={this.changeState} variant="contained" color="primary">
                    learnt words      </Button>
                </div>
                {
                    this.state.learnt ?
                    (this.words(this.state.all)):
                    (this.words(this.state.custom))
                }
            </div>
        );
    }
}

export default UploadScreen;
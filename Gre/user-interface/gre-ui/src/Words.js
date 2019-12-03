import React, { Component } from "react";
import axios from "axios";
import { Button} from "@material-ui/core";
import DisplayTable from "./DisplayTable";
import "./App.css";
class Words extends Component {
  constructor(props) {
    super(props);
    this.state = {
      learnt: 1,
      all: [],
      custom: [],
      type: ""
    };
    this.handleDelete = this.handleDelete.bind(this);
  }

  componentDidMount() {
    console.log(this.props.id);
    axios.get("http://localhost:8080/words").then(response => {
      this.setState({ all: response.data });
    });
    var url = "http://localhost:8080/user/" + this.props.id;
    axios.get(url).then(response => {
      this.setState({ custom: response.data });
    });
    console.log("words mount mtd executed");
  }
  handleDelete(id) {
    const myFil = word => word.id !== id;
    const oldWords = this.state.custom;
    const newWords = oldWords.filter(myFil);
    this.setState({ custom: newWords });
  }

  handleAdd(id) {
    let oldWords = this.state.custom;
    let newWords = oldWords.concat(this.state.all[id]);
    this.setState({ custom: newWords });
  }

  render() {
    return (
      <div>
        <div>
          <Button
            style={{ margin: 15 }}
            onClick={() => {
              this.setState({ learnt: 1 });
            }}
            variant="contained"
            color="primary"
          >
            Show Words{" "}
          </Button>
          <Button
            style={{ margin: 15 }}
            onClick={() => {
              this.setState({ learnt: 0 });
            }}
            variant="contained"
            color="primary"
          >
            Learnt words{" "}
          </Button>
        </div>
        {this.state.learnt ? (
          <DisplayTable
            userid={this.props.id}
            data={this.state.all}
            type="all"
            onAdd={id => this.handleAdd(id)}
          />
        ) : (
          <DisplayTable
            userid={this.props.id}
            data={this.state.custom}
            type="custom"
            onDelete={id => this.handleDelete(id)}
          />
        )}
      </div>
    );
  }
}

export default Words;

import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import './components/Dropdown'
import Dropdown from "./components/Dropdown";

class App extends Component {
  render() {
    return (
      <div className="App">
        <main>
          <section className="mainObjects">
              <Dropdown />
              <Dropdown />
              <Dropdown />
              <Dropdown />
          </section>
        </main>
      </div>
    );
  }
}

export default App;

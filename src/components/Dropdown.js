import React , {Component} from 'react' ;
import ReactDOM from 'react-dom' ;
import CheckBox from './CheckBox'
import SearchBox from './SearchBox'

class Dropdown extends Component{
    constructor(props){
        super(props) ;
        this.state = {
            boxCount: 0 ,
            rows: this.boxCount/4 ,// to be edited
            cols:4
        } ;
        this.numberOfBoxes  = this.numberOfBoxes.bind(this) ;
        this.createTable    = this.createTable.bind(this) ;
    }
    numberOfBoxes(i){
        this.setState(
            prevState =>{
                return {boxCount: prevState.boxCount + i}
            })
    }
    createTable() {
        let table = [];
        for (let row = 0; row < this.rows; row++) {
            let children = [];
            for (let col = 0; col < this.cols; col++) {
                children.push(<td><CheckBox/></td>)
            }
            table.push(<tr> {children}</tr>)
        }
        return table
    }

    render(){
        return(
            <div>
                <button className="dropdown dropdown-toggle" >
                    <ul>
                        <li><SearchBox /></li>
                        <li><table>{this.createTable()}</table></li>
                    </ul>
                </button>
                <br />
            </div>
        ) ;
    }

}

export default Dropdown ;



import React ,{Component} from 'react'
import ReactDOM from 'react-dom' ;

class CheckBox extends Component {
    constructor(props) {
        super(props);
        this.name =  '' ;
        this.state = {checked: false , name:'notnamed' , skillType:''};
        this.checkedOnClick = this.checkedOnClick(this)
    }



    checkOnClick() {
        this.setState(
            prevState => {
                return {checked: !prevState.checked}
            })
    }

    render(){
        return (<input type="checkbox" checked={this.state} onClick={this.checkedOnClick} name={this.name} />)
    }
}

export default CheckBox ;
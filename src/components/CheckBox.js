import React ,{Component} from 'react'
import ReactDOM from 'react-dom' ;
import { Form , FormGroup , Input , Label} from 'reactstrap';
class CheckBox extends Component {
    constructor(props) {
        super(props);
        this.name =  '' ;
        this.id = 0 ;
        this.state = {checked: false , name: props.name , skillType: props.id};
        this.checkOnClick = this.checkOnClick.bind(this)
    }

    checkOnClick() {
        this.setState(
            prevState => {
                return {checked: !prevState.checked  }
            })
    }

    render(){
        return (

            <FormGroup check>
                <Label check>
                    <Input type="checkbox" />
                    {this.props.details.name}
                </Label>
            </FormGroup>

        )
    }
}

export default CheckBox ;
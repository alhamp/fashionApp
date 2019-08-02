import React, {Component} from 'react'
import TextField from '../components/TextField'
import SelectField from '../components/SelectField'
import TextArea from '../components/TextArea'

const bodyTypeArray = ['straight-body','pear-body','oval-body', 'diamond-body','hourglass-body','top-hourglass-body','inverted-triangle-body']
const sizeArray = ['US 0', 'US 2', 'US 4', 'US 8', 'US 10', 'US 12', 'US 14', 'US 16', 'US 18', 'US 20']

class ReviewContainer extends Component {
    constructor(props){
        super(props)
        this.state = {
            bodyType:'',
            itemSize:'',
            quality:'',
            comment:'',
            photo:'',
            rating:''
        }
        this.handleChange = this.handleChange.bind(this)
        this.handleSubmit = this.handleSubmit.bind(this)
        this.handleClear = this.handleClear.bind(this)
    }

    handleChange(event){
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    handleSubmit(event){
        event.preventDefault()
        this.props.addNewReview(this.state)
        this.handleClear()
    }

    handleClear(){
        this.setState({
            bodyType:'',
            itemSize:'',
            quality:'',
            comment:'',
            photo:'',
            rating:''
        })
    }

    render() {
        
        let bodyTypeOptions = bodyTypeArray.map((name, i) => {
            return <option key={i} value={i}>{name}</option>
        })
        
        let sizeOptions = sizeArray.map((name, i) => {
            return <option key={i} value={i}>{name}</option>
        })
        let options =[]
        for(let i=1; i<6; i++) {
            options.push(<option key={i} value={i}>{i}</option>)
        }
        
        return (
            <form onSubmit={this.handleSubmit} className="columns small-12">
                <h4>Add a review</h4>
                <SelectField
                    label="Overall Rating"
                    name="rating"
                    optionElements={options}
                    handleChange={this.handleChange}
                    value={this.state.rating}
                />
                <SelectField
                    label="Quality"
                    name="quality"
                    optionElements={options}
                    handleChange={this.handleChange}
                    value={this.state.quality}
                />
                <SelectField
                    label="Body Type"
                    name="bodyType"
                    optionElements={bodyTypeOptions}
                    handleChange={this.handleChange}
                    value={this.state.bodyType}
                />
                <SelectField 
                    label="Size"
                    name="itemSize"
                    optionElements={sizeOptions}
                    handleChange={this.handleChange}
                    value={this.state.itemSize}
                />
                <div>
                    <TextField 
                        label="Photo"
                        name="photo"
                        handleChange={this.handleChange}
                        value={this.state.photo}
                    />
                </div>
                <div>
                    <TextArea 
                        label="Comment"
                        name="comment"
                        handleChange={this.handleChange}
                        value={this.state.comment}
                    />
                </div>
                <div>
                <input className="button" type="submit" value="Submit" />
                </div>
            </form>
        )
    }
}
export default ReviewContainer

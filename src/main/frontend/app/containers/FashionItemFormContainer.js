import React, {Component} from 'react';
                                        import TextField from '../components/TextField'
                                        import SelectField from '../components/SelectField'
                                        import TextArea from '../components/TextArea'
                                        import NumberField from '../components/NumberField'


                                        class FashionItemFormContainer extends Component {
                                        constructor(props){
                                            super(props);
                                            this.state = {
                                                name: '',
                                                clothingType:'',
                                                bodyType:'',
                                                measurements:'',
                                                styles:'',
                                                brand:'',
                                                fabricWeight:'',
                                                quality:'',
                                                itemSize:'',
                                                photo:'',
                                                budget:''
                                            };
                                            this.handleSubmit = this.handleSubmit.bind(this)
                                            this.clearForm = this.clearForm.bind(this)
                                            this.handleChange = this.handleChange.bind(this)
                                        }

                                        handleChange(event) {
                                          this.setState({ [event.target.name]: event.target.value})
                                        }

                                        handleSubmit(event) {
                                            event.preventDefault()
                                            this.props.addNewItem(this.state)
                                            this.clearForm()
                                        }

                                        clearForm(){
                                            this.setState({
                                                name: '',
                                                clothingType:'',
                                                bodyType:'',
                                                measurements:'',
                                                styles:'',
                                                brand:'',
                                                fabricWeight:'',
                                                quality:'',
                                                itemSize:'',
                                                photo:'',
                                                budget:''
                                            })
                                        }

                                        render() {

                                                let clothingTypeArray = ['Tops','jackets','blazers', 'coats','dresses',
                                                'jumpsuits','knitwear','shirts|blouses','t-shirts','pants','jeans','shorts',
                                                'skirts','swimwear']
                                                let clothingTypeOptions = clothingTypeArray.map((name, i) => {
                                                    return <option key={i} value={i}>{name}</option>
                                                })

                                                let bodyTypeArray = ['straight-body','pear-body','oval-body', 'diamond-body','hourglass-body','top-hourglass-body','inverted-triangle-body',]
                                                let bodyTypeOptions = bodyTypeArray.map((name, i) => {
                                                    return <option key={i} value={i}>{name}</option>
                                                })

                                                let sizeArray = ['US 0', 'US 2', 'US 4', 'US 8', 'US 10', 'US 12', 'US 14', 'US 16', 'US 18', 'US 20']
                                                let sizeOptions = sizeArray.map((name, i) => {
                                                    return <option key={i} value={i}>{name}</option>
                                                })

                                                let stylesArray =['formal-office','business-casual','casual-chic','sports-wear',
                                                'evening-black-tie','party/wedding','pool-party','vocation','maternity','streetWear',
                                                'cowGirl','hip-hop','rocker-chick','military']
                                                let stylesOptions = stylesArray.map((name, i) => {
                                                    return <option key={i} value={i}>{name}</option>
                                                })
                                                let options =[]
                                                for(let i=1; i<6; i++) {
                                                    options.push(<option key={i} value={i}>{i}</option>)
                                                }

                                                return (
                                                    <form onSubmit={this.handleSubmit}>
                                                        <h2>Add Your Fashion Item:</h2>
                                                        <TextField
                                                            label="Fashion Item Name"
                                                            name="name"
                                                            handleChange={this.handleChange}
                                                            value={this.state.name}
                                                        />
                                                        <div>
                                                        <TextField
                                                            label="Brand"
                                                            name="brand"
                                                            handleChange={this.handleChange}
                                                            value={this.state.brand}
                                                        />
                                                        </div>
                                                        <div>
                                                        <SelectField
                                                            label="Clothing Type"
                                                            name="clothingType"
                                                            optionElements={clothingTypeOptions}
                                                            handleChange={this.handleChange}
                                                            value={this.state.clothingType}
                                                            />
                                                        </div>
                                                        <div>
                                                        <SelectField
                                                            label="Size"
                                                            name="itemSize"
                                                            optionElements={sizeOptions}
                                                            handleChange={this.handleChange}
                                                            value={this.state.itemSize}
                                                        />
                                                        </div>
                                                        <div>
                                                        <SelectField
                                                            label="Body Type"
                                                            name="bodyType"
                                                            optionElements={bodyTypeOptions}
                                                            handleChange={this.handleChange}
                                                            value={this.state.bodyType}
                                                        />
                                                           </div>
                                                           <div>
                                                         <TextField
                                                             label="Measurements"
                                                             name="measurements"
                                                             handleChange={this.handleChange}
                                                             value={this.state.measurements}
                                                         />
                                                          </div>
                                                          <div>
                                                        <SelectField
                                                            label="Styles to match"
                                                            name="styles"
                                                            optionElements={stylesOptions}
                                                            handleChange={this.handleChange}
                                                            value={this.state.styles}
                                                        />
                                                        </div>
                                                        <div>
                                                           <NumberField
                                                            label="Price"
                                                            name="budget"
                                                            handleChange={this.handleChange}
                                                            value={this.state.budget}
                                                        />
                                                        </div>
                                                        <div>
                                                            <TextField
                                                                label="Photo"
                                                                name="photo"
                                                                handleChange={this.handleChange}
                                                                value={this.state.photo}
                                                            />
                                                        </div>
                                                        <SelectField
                                                            label="Quality"
                                                            name="quality"
                                                            optionElements={options}
                                                            handleChange={this.handleChange}
                                                            value={this.state.quality}
                                                        />
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

                                        export default FashionItemFormContainer;
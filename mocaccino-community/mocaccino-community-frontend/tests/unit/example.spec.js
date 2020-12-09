import { expect } from 'chai'
import { shallowMount } from '@vue/test-utils'
import TestComponent from '@/components/TestComponent.vue'

describe('TestComponent.vue', () => {
  it('renders props.msg when passed', () => {
    const msg = 'new message'
    const wrapper = shallowMount(TestComponent, {
      propsData: { msg }
    })
    expect(wrapper.text()).to.include(msg)
  })
})

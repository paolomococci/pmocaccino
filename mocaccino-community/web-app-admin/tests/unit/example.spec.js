import { expect } from 'chai'
import { shallowMount } from '@vue/test-utils'
import Welcome from '@/components/Welcome'

describe('Welcome.vue', () => {
  it('renders props.message when passed', () => {
    const message = 'new message';
    const wrapper = shallowMount(Welcome, {
      propsData: {message}
    });
    expect(wrapper.text()).to.include(message);
  });
});
